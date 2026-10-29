
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import './App.css'
import Navbar from './demo_component/Navbar'
import SampleCode from './demo_component/SampleCode'

import UseFetchApi from './demo_component/UseFetchApi'
import Home from './components/Home'
import Dashboard from './components/Dashboard'
import Login from './components/Login'
import Registration from './components/Registration'
import AddEmployee from './demo_component/AddEmployee'


function App() {
//   const employee=[
//   {  ename:"Rahul", empid:"120"},
//   {  ename:"sahul", empid:"121"},
//   {  ename:"menon", empid:"122"},
//   {  ename:"rakes", empid:"123"},
//   ]


  return (
    <>
      <BrowserRouter>
       <Navbar/>
       <Routes>
         <Route path="/" element={<Home/>}/>
         <Route path="/login" element={<Login/>}/>
         <Route path="/register" element={<Registration/>}/>
         <Route path="/dashboard" element={<Dashboard/>}/>
       </Routes>
      </BrowserRouter>
    
    </>
  );
}


export default App
