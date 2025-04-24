import dbConnect from '../../../lib/db';
import Task from '../../../models/Task';

export default async function handler(req, res) {
  await dbConnect();

  switch (req.method) {
    case 'GET':
      try {
        const pendingTasks = await Task.find({ status: 'TaskPending' }).sort({ createdAt: -1 });
        const completedTasks = await Task.find({ status: 'TaskCompleted' }).sort({ createdAt: -1 });
        res.status(200).json({ pendingTasks, completedTasks });
      } catch (error) {
        res.status(500).json({ error: 'Error fetching tasks' });
      }
      break;

    case 'POST':
      try {
        const task = new Task({
          title: req.body.title,
          status: 'TaskPending',
        });
        await task.save();
        res.status(201).json(task);
      } catch (error) {
        res.status(500).json({ error: 'Error creating task' });
      }
      break;

    default:
      res.setHeader('Allow', ['GET', 'POST']);
      res.status(405).end(`Method ${req.method} Not Allowed`);
  }
}