
import React, { useEffect, useState } from 'react'
import { useLocation } from 'react-router-dom'

function Dashboard() {
  const location = useLocation()
  const employee = location.state?.employee

  const [attendance, setAttendance] = useState([])

  // Fetch attendance records
  async function getAttendance() {
    if (!employee) return

    try {
      const response = await fetch(
        `http://localhost:8080/v1/user/attendance/dashboard/${employee.empId}`
      )

      if (response.ok) {
        const data = await response.json()
        setAttendance(data)
      }
    } catch (error) {
      console.log(error)
    }
  }

  useEffect(() => {
    getAttendance()
  }, [])

  // Check In
  async function checkIn() {
    try {
      const response = await fetch(
        'http://localhost:8080/v1/user/attendance/markAttendance',
        {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify({
            employee: {
              empId: Number(employee.empId)
            }
          })
        }
      )

      const message = await response.text()

      if (response.ok && message === 'Attendance marked successfully') {
        alert(message)
        getAttendance()
      } else {
        alert(message || 'Check-in failed')
      }
    } catch (error) {
      console.log(error)
      alert('Unable to connect to the server')
    }
  }

  // Check Out
  async function checkout() {
    alert('Checkout endpoint is not implemented in your backend yet.')
  }

  if (!employee) {
    return <h3>Please log in first.</h3>
  }

  return (
    <div className="container mt-4">
      <h2>Employee Dashboard</h2>

      <button
        className="btn btn-success me-2"
        onClick={checkIn}
      >
        Check In
      </button>

      <button
        className="btn btn-danger"
        onClick={checkout}
      >
        Check Out
      </button>

      <hr />

      <p>Name: {employee.emp_name}</p>
      <p>Employee ID: {employee.empId}</p>
      <p>Email: {employee.email}</p>

      <hr />

      <h3>Attendance Summary</h3>

      <div className="card p-3 mb-3">
        <h5>Total Present Days</h5>
        <h2>{attendance.length}</h2>
      </div>

      <h4>Attendance Records</h4>

      <table className="table table-bordered">
        <thead>
          <tr>
            <th>Date</th>
            <th>In Time</th>
            <th>Out Time</th>
            <th>Comment</th>
          </tr>
        </thead>

        <tbody>
          {attendance.map((item) => (
            <tr key={item.attendanceId}>
              <td>{item.attendancedate}</td>
              <td>{item.inTime || '-'}</td>
              <td>{item.outTime || '-'}</td>
              <td>{item.comment || '-'}</td>
            </tr>
          ))}

          {attendance.length === 0 && (
            <tr>
              <td colSpan="4" className="text-center">
                No attendance records found
              </td>
            </tr>
          )}
        </tbody>
      </table>
    </div>
  )
}

export default Dashboard
