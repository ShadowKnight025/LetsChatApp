import React, { Component } from 'react';

class Footer extends Component {
    constructor(props) {
        super(props);
        
    }
    
    render() {
        return (
            <div>
                <footer className='footer'>
                    <span className='text-muted' >All rights reserved 2022 @Lets Chat</span>
                </footer>
            </div>
        );
    }
}

export default Footer;