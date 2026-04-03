import { Link } from "react-router-dom";

export default function Dashboard() {
  return (
    <div className="container">
      <h1>Dashboard</h1>

      <a href="/local">Local Users</a>
      <a href="/users">Users API</a>
      <a href="/posts">Fake API Posts</a>
    </div>
  );
}