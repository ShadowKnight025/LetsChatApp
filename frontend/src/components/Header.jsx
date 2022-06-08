import React, { Component } from 'react';
import logo from './logo.png';
import AppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import CssBaseline from '@mui/material/CssBaseline';

class Header extends Component {
    constructor(props) {
        super(props);
        
    }
    
    render() {
        return (
            <div>
                <React.Fragment>
            <CssBaseline />
            <AppBar sx={{ mt: 0, mb: 2, bgcolor: '#b71c1c',}}>
              <Toolbar>
                <Typography variant="h6" component="div"> 
                    <img className='logo' src={logo} width="50" />
                    Lets Chat
                </Typography>
              </Toolbar>
            </AppBar>
          <Toolbar />
        </React.Fragment>
            </div>
        );
    }
}

export default Header;