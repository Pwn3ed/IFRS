import dbConnect from '../../../lib/db';
import Task from '../../../models/Task';

export default async function handler(req, res) {
  res.setHeader('Content-Type', 'application/json');

  try {
    await dbConnect();
  } catch (dbError) {
    console.error('Database connection error:', dbError);
    return res.status(500).json({
      success: false,
      error: 'Database connection failed',
      details: dbError.message
    });
  }

  const { id } = req.query;

  if (!id || typeof id !== 'string') {
    return res.status(400).json({
      success: false,
      error: 'Invalid task ID'
    });
  }

  switch (req.method) {
    case 'PUT':
      try {
        const task = await Task.findById(id);
        if (!task) {
          return res.status(404).json({
            success: false,
            error: 'Task not found'
          });
        }

        task.status = task.status === 'TaskPending' ? 'TaskCompleted' : 'TaskPending';
        const updatedTask = await task.save();

        return res.status(200).json({
          success: true,
          task: updatedTask
        });
      } catch (error) {
        console.error('Error updating task:', error);
        return res.status(500).json({
          success: false,
          error: 'Failed to update task',
          details: error.message
        });
      }

    case 'DELETE':
      try {
        const deletedTask = await Task.findByIdAndDelete(id);
        if (!deletedTask) {
          return res.status(404).json({
            success: false,
            error: 'Task not found'
          });
        }

        return res.status(200).json({
          success: true,
          message: 'Task deleted successfully'
        });
      } catch (error) {
        console.error('Error deleting task:', error);
        return res.status(500).json({
          success: false,
          error: 'Failed to delete task',
          details: error.message
        });
      }

    default:
      res.setHeader('Allow', ['PUT', 'DELETE']);
      return res.status(405).json({
        success: false,
        error: `Method ${req.method} Not Allowed`
      });
  }
}