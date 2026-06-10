import { useState } from "react";

function App() {
  const [students, setStudents] = useState([]);
  const [count, setCount] = useState(0);
  const [name, setName] = useState("");
  const [course, setCourse] = useState("");

  //function to get Student data from Backend
  const getStudents = async () => {
    const response = await fetch("http://localhost:8080/students");
    const data = await response.json();
    console.log(data);
    setStudents(data);
  };

  const getBcaStudents = async () => {
    const response = await fetch("http://localhost:8080/students/bca");
    const data = await response.json();
    console.log(data);
    setStudents(data);
  };
  const fetchTotalStudentsCount = async () => {
    const response = await fetch("http://localhost:8080/students/count");
    const data = await response.json();
    console.log(data);
    setCount(data);
  };

  const addStudent = async () => {
    const response = await fetch("http://localhost:8080/students", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ name, course }),
    });

    if (response.ok) {
      alert("Student registered successfully!");
    } else {
      alert("Failed to register student.");
    }
  };

  return (
    <div>
      <button onClick={getStudents}>Fetch Students</button>

      <button onClick={getBcaStudents}>Show BCA Students</button>

      <ul>
        {students.map((student) => (
          <li key={student.id}>
            {student.name} - {student.course}
          </li>
        ))}
      </ul>

      <button onClick={fetchTotalStudentsCount}>Total Students</button>
      <p>Total Students: {count}</p>

      <h1>Student Registration Form</h1>
      <input
        type="text"
        placeholder="Name"
        value={name}
        onChange={(e) => setName(e.target.value)}
      />
      <input
        type="text"
        placeholder="Course"
        value={course}
        onChange={(e) => setCourse(e.target.value)}
      />
      <button onClick={addStudent}>Register</button>
    </div>
  );
}
export default App;
