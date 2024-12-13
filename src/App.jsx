import React, { useState, useEffect } from "react";
import axios from "axios";
import './App.css';

function App() {
  // State to hold the student details
  const [students, setStudents] = useState([]);
  const [studentData, setStudentData] = useState({
    name: "",
    email: "",
    profession: "",
  });

  // API base URL (replace with your Spring Boot server URL)
  const API_URL = "http://localhost:8080/students"; // Modify this if needed

  // Fetch students on component mount
  useEffect(() => {
    axios.get(API_URL)
      .then((response) => {
        setStudents(response.data);
      })
      .catch((error) => {
        console.error("There was an error fetching students!", error);
      });
  }, []);

  // Handle form field changes
  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setStudentData({
      ...studentData,
      [name]: value,
    });
  };

  // Add new student to the backend
  const addStudent = (e) => {
    e.preventDefault();
    if (studentData.name && studentData.email && studentData.profession) {
      axios.post(API_URL, studentData)
        .then((response) => {
          setStudents([...students, response.data]);  // Add new student to list
          setStudentData({ name: "", email: "", profession: "" });  // Clear form
        })
        .catch((error) => {
          console.error("There was an error adding the student!", error);
        });
    } else {
      alert("Please fill all fields");
    }
  };

  // Delete student by ID
  const deleteStudent = (id) => {
    axios.delete(`${API_URL}/${id}`)
      .then(() => {
        setStudents(students.filter(student => student.id !== id)); // Remove from list
      })
      .catch((error) => {
        console.error("There was an error deleting the student!", error);
      });
  };

  return (
    <div className="App">
      <h1>Student Details</h1>

      {/* Form to enter student details */}
      <form onSubmit={addStudent}>
        <div>
          <label>Name:</label>
          <input
            type="text"
            name="name"
            value={studentData.name}
            onChange={handleInputChange}
            required
          />
        </div>
        <div>
          <label>Email:</label>
          <input
            type="email"
            name="email"
            value={studentData.email}
            onChange={handleInputChange}
            required
          />
        </div>
        <div>
          <label>Profession:</label>
          <input
            type="text"
            name="profession"
            value={studentData.profession}
            onChange={handleInputChange}
            required
          />
        </div>
        <button type="submit">Add Student</button>
      </form>

      {/* Displaying the list of students */}
      <h2>Student List</h2>
      <ul>
        {students.map((student) => (
          <li key={student.id}>
            <strong>{student.name}</strong> ({student.email}) - {student.profession}
            <button onClick={() => deleteStudent(student.id)}>Delete</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;
