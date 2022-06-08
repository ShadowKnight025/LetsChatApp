import './App.css';
import{BrowserRouter as Router, Route, Routes, Link} from 'react-router-dom';
import Login from './components/Login';
import Signup from './components/Signup';
import Header from './components/Header';
import Footer from './components/Footer';
import Reset from './components/Reset';

function App() {
  return (
    <div>
      <Header/>
          <div className="container">
            <Routes>
              <Route path="/" element={<Login/>}></Route>
              <Route path="/login" element={<Login/>}></Route>
              <Route path="/signup" element={<Signup/>}></Route>
              <Route path="/reset" element={<Reset/>}></Route>
            </Routes>
          </div>
  </div>
  );
}

export default App;
