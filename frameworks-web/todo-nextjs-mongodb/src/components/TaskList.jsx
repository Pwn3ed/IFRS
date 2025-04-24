const TaskList = ({ tasks, status, onToggleStatus, onDelete }) => {
    return (
      <div className="w-full max-w-md mb-8">
        <h2 className="text-xl mb-4 ">
          {status === 'TaskPending' ? 'Pending Tasks' : 'Completed Tasks'}
        </h2>
        {tasks.length === 0 ? (
          <p className="">No tasks here yet</p>
        ) : (
          <ul className="space-y-3">
            {tasks.map((task) => (
              <li
                key={task._id}
                className="flex items-center justify-between p-4 "
              >
                <span className={`flex-1 ${status === 'TaskCompleted' ? 'line-through text-gray-400' : 'text-gray-200'}`}>
                  {task.title}
                </span>
                <div className="flex ml-4">
                  <button
                    onClick={() => onToggleStatus(task._id)}
                    className={`px-3 py-1  text-sm ${
                      status === 'TaskPending'
                        ? 'bg-green'
                        : 'bg-gray'
                    }`}
                  >
                    {status === 'TaskPending' ? '✓' : '↩'}
                  </button>
                  <button
                    onClick={() => onDelete(task._id)}
                    className="px-3 py-1 bg-red"
                  >
                    ✕
                  </button>
                </div>
              </li>
            ))}
          </ul>
        )}
      </div>
    );
  };
  
  export default TaskList;