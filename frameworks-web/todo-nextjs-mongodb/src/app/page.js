'use client'

import { useState, useEffect } from 'react';
import TaskForm from '../components/TaskForm';
import TaskList from '../components/TaskList';

export default function Home() {
  const [pendingTasks, setPendingTasks] = useState([]);
  const [completedTasks, setCompletedTasks] = useState([]);
  const [isLoading, setIsLoading] = useState(true);

  const fetchTasks = async () => {
    try {
      const response = await fetch('/api/tasks');
      const data = await response.json();
      setPendingTasks(data.pendingTasks);
      setCompletedTasks(data.completedTasks);
    } catch (error) {
      console.error('Error fetching tasks:', error);
    } finally {
      setIsLoading(false);
    }
  };

  useEffect(() => {
    fetchTasks();
  }, []);

  const handleAddTask = (newTask) => {
    setPendingTasks([newTask, ...pendingTasks]);
  };

  const handleToggleStatus = async (taskId) => {
    try {
      const response = await fetch(`/api/tasks/${taskId}`, {
        method: 'PUT',
      });

      if (response.ok) {
        const updatedTask = await response.json();
        
        if (updatedTask.status === 'TaskCompleted') {
          setPendingTasks(pendingTasks.filter(task => task._id !== taskId));
          setCompletedTasks([updatedTask, ...completedTasks]);
        } else {
          setCompletedTasks(completedTasks.filter(task => task._id !== taskId));
          setPendingTasks([updatedTask, ...pendingTasks]);
        }
      }
    } catch (error) {
      console.error('Error toggling task status:', error);
    }
  };

  const handleDeleteTask = async (taskId) => {
    try {
      const response = await fetch(`/api/tasks/${taskId}`, {
        method: 'DELETE',
      });

      if (response.ok) {
        setPendingTasks(pendingTasks.filter(task => task._id !== taskId));
        setCompletedTasks(completedTasks.filter(task => task._id !== taskId));
      }
    } catch (error) {
      console.error('Error deleting task:', error);
    }
  };

  if (isLoading) {
    return (
      <div className="min-h-screen bg-gray-900 flex items-center justify-center">
        <div className="text-gray-400">Loading tasks...</div>
      </div>
    );
  }

  return (
    <div className="min-h-screen flex flex-col items-center py-12 px-4">
      <div className="w-full max-w-md">
        <h1 className="text-3xl font-bold mb-8 text-center">To-Do List</h1>
        
        <TaskForm onAddTask={handleAddTask} />
        
        <TaskList
          tasks={pendingTasks}
          status="TaskPending"
          onToggleStatus={handleToggleStatus}
          onDelete={handleDeleteTask}
        />
        
        <TaskList
          tasks={completedTasks}
          status="TaskCompleted"
          onToggleStatus={handleToggleStatus}
          onDelete={handleDeleteTask}
        />
      </div>
    </div>
  );
}