import clientPromise from '../lib/dbConnect';

const COLLECTION_NAME = 'tasks';

async function getCollection() {
  const client = await clientPromise;
  const db = client.db(process.env.NEXT_PUBLIC_DB_NAME);
  return db.collection(COLLECTION_NAME);
}

export async function getTasks() {
  const collection = await getCollection();
  return collection.find({}).toArray();
}

export async function addTask(title) {
  const collection = await getCollection();
  const result = await collection.insertOne({
    title,
    completed: false,
    createdAt: new Date(),
  });
  return result;
}

export async function updateTaskStatus(id, completed) {
  const collection = await getCollection();
  const result = await collection.updateOne(
    { _id: id },
    { $set: { completed, updatedAt: new Date() } }
  );
  return result;
}

export async function deleteTask(id) {
  const collection = await getCollection();
  const result = await collection.deleteOne({ _id: id });
  return result;
}