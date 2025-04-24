import dbConnect from '../../../lib/db';
import Task from '../../../models/Task';

export default async function handler(req, res) {
  try {
    await dbConnect();

    switch (req.method) {
      case 'GET':
        try {
          const [pendingTasks, completedTasks] = await Promise.all([
            Task.find({ status: 'TaskPending' }).sort({ createdAt: -1 }).lean(),
            Task.find({ status: 'TaskCompleted' }).sort({ createdAt: -1 }).lean()
          ]);
          
          res.status(200).json({ 
            pendingTasks: Array.isArray(pendingTasks) ? pendingTasks : [], 
            completedTasks: Array.isArray(completedTasks) ? completedTasks : [] 
          });
        } catch (error) {
          console.error('Error fetching tasks:', error);
          res.status(500).json({ 
            pendingTasks: [], 
            completedTasks: [], 
            error: 'Error fetching tasks' 
          });
        }
        break;

      case 'POST':
        try {
          const { title } = req.body;
          
          if (!title || typeof title !== 'string' || title.trim() === '') {
            return res.status(400).json({ error: 'Title is required' });
          }
          
          const task = new Task({
            title: title.trim(),
            status: 'TaskPending',
          });
          
          await task.save();
          res.status(201).json(task);
        } catch (error) {
          console.error('Error creating task:', error);
          res.status(500).json({ error: 'Error creating task' });
        }
        break;

      default:
        res.setHeader('Allow', ['GET', 'POST']);
        res.status(405).end(`Method ${req.method} Not Allowed`);
    }
  } catch (dbError) {
    console.error('Database connection error:', dbError);
    res.status(500).json({ error: 'Database connection error' });
  }
}