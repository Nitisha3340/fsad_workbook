import { useEffect, useState } from "react";
import axios from "axios";

export default function FakePostList() {
  const [posts, setPosts] = useState([]);
  const [filtered, setFiltered] = useState([]);

  const fetchData = () => {
    axios.get("https://dummyjson.com/posts")
      .then(res => {
        setPosts(res.data.posts);
        setFiltered(res.data.posts);
      });
  };

  useEffect(() => {
    fetchData();
  }, []);

  const handleFilter = (e) => {
    const val = e.target.value;
    if (val === "all") setFiltered(posts);
    else setFiltered(posts.filter(p => p.userId == val));
  };

  return (
  <div className="container">
    <h2>Fake API Posts</h2>

    <button onClick={fetchData}>Refresh</button>

    <select onChange={handleFilter}>
      <option value="all">All</option>
      <option value="1">User 1</option>
      <option value="2">User 2</option>
    </select>

    {filtered.map(post => (
      <div className="card" key={post.id}>
        <h4>{post.title}</h4>
        <p>{post.body}</p>
      </div>
    ))}
  </div>
);
}