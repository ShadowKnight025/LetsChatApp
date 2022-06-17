import './App.css';
import{BrowserRouter as Router, Route, Routes, Link} from 'react-router-dom';
import { ThemeProvider } from '@material-ui/core/styles'
import CssBaseline from '@material-ui/core/CssBaseline'
import Login from './components/Login';
import Signup from './components/Signup';
import Header from './components/Header';
import Footer from './components/Footer';
import Reset from './components/Reset';
import Main from './components/Main';
import theme from './components/theme';

function App() {
  return (
    <ThemeProvider theme={theme}>
       <CssBaseline />
    <div>
      <Header/>
          <div className="container">
            <Routes>
              <Route path="/" element={<Login/>}></Route>
              <Route path="/login" element={<Login/>}></Route>
              <Route path="/signup" element={<Signup/>}></Route>
              <Route path="/reset" element={<Reset/>}></Route>
              <Route path="/main" element={<Main/>}></Route>
            </Routes>
          </div>
      </div>
    </ThemeProvider>
  );
}

export default App;
