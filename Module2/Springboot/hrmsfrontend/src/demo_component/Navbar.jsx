
import { Link } from 'react-router-dom'

function Navbar() {
  return (
    <>
     <nav>
      <Link to="/">Home</Link> <br />
      <Link to="/register">Add Employee</Link> <br />
      <Link to="/login">Login</Link> <br />
      <Link to="/removeEmployee">Remove Employee</Link>
      <br />
      <Link to="/findById">Find Employee</Link>
      <br />
     </nav>
    </>
  )
}

export default Navbar