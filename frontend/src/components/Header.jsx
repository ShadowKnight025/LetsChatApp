import React, { Component } from 'react';
import logo from './logo.png';

class Header extends Component {
    constructor(props) {
        super(props);
        
    }
    
    render() {
        return (
            <div>
                <header>
                <nav className='navbar navbar-expand-md navbar-dark bg-dark'>
                        <div>
                            <a href="login" className='navbar-brand'>Lets Chat</a>
                        </div>
                        <div>
                            <img src={logo} width="35" />
                        </div>
                    </nav>
                </header>
            </div>
        );
    }
}

export default Header;