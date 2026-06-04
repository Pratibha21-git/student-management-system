import { useState } from 'react';
function App(){
    const[students, setStudents] = useState(null);
    const getStudents = async () => {
            const response = await fetch('http://localhost:8080/students');
            const data = await response.json();
            setStudents(data);
        
    };
    return (
        <div>

            <button onClick = {getStudents}>
                Fetch Student
            </button>
            <h1>Student Information</h1>
            <h1>{students?.name}</h1>
            <h1>{students?.id}</h1>
            <h1>{students?.course}</h1>
        </div>
    );
}
export default App;