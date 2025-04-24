import dbConnect from '../../../lib/db';
import Task from '../../../models/Task';

export default async function handler(req, res) {
  await dbConnect();
  const { id } = req.query;

  switch (req.method) {
    case 'PUT':
      try {
        const task = await Task.findById(id);
        if (!task) {
          return res.status(404).json({ error: 'Task not found' });
        }
        
        task.status = task.status === 'TaskPending' ? 'TaskCompleted' : 'TaskPending';
        await task.save();
        res.status(200).json(task);
      } catch (error) {
        res.status(500).json({ error: 'Error updating task' });
      }
      break;

    case 'DELETE':
      try {
        const task = await Task.findByIdAndDelete(id);
        if (!task) {
          return res.status(404).json({ error: 'Task not found' });
        }
        res.status(200).json({ message: 'Task deleted successfully' });
      } catch (error) {
        res.status(500).json({ error: 'Error deleting task' });
      }
      break;

    default:
      res.setHeader('Allow', ['PUT', 'DELETE']);
      res.status(405).end(`Method ${req.method} Not Allowed`);
  }
}