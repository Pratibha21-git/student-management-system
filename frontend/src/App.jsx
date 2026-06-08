import { useState } from "react";

function App(){
  const [students, setStudents] = useState([]);
  const [count, setCount] = useState(0);

  //function to get Student data from Backend
  const getStudents = async ()=>{
    const response = await fetch('http://localhost:8080/students');
    const data = await response.json();
    console.log(data);
    setStudents(data);
  }

    const getBcaStudents = async ()=>{
    const response = await fetch('http://localhost:8080/students/bca');
    const data = await response.json();
    console.log(data);
    setStudents(data);
  }
  const fetchTotalStudentsCount = async ()=>{
    const response = await fetch('http://localhost:8080/students/count');
    const data = await response.json();
    console.log(data);
    setCount(data);
  };

  return(
    <div>
      <button onClick={getStudents}>
        Fetch Students
      </button>

      <button onClick={getBcaStudents}>
        Show BCA Students
      </button>
      
      <ul>
       {students.map(student=>(
        <li key={student.id}>
          {student.name} -  {student.course}
        </li>
       ))
       }
      </ul>

      <button onClick = {fetchTotalStudentsCount}>
        Total Students
      </button>
      <p>Total Students: {count}</p>

    </div>
  )
}
export default App;