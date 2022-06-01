import React, { Component } from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faEnvelope } from '@fortawesome/free-solid-svg-icons'

class Reset extends Component {
    constructor(props) {
        super(props);
        
    }
    
    render() {
        return (
            <div>
                <div className="container">
                    <div className="row">
                        <div className='card col-md-6 offset-md-3 offset-md-3'>
                            <h3 className="text-center">Reset Password</h3>
                            <div className="card-body">
                                <form>
                                <div className="form-group">
                                        <label>Email</label>
                                        <div className='input-group-prepend'>
                                            <span className="input-group-text">
                                            <FontAwesomeIcon icon={faEnvelope}/>
                                            </span>
                                            <input placeholder='Email' name='email' className='form-control' type="email" />
                                        </div>
                                    </div>
                                    <button className='btn btn-success'>Send Link</button>
                                    <br />
                                    <a href="login">Login</a> <br />
                                    <a href="signup">Create new account</a>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                
            </div>
        );
    }
}

export default Reset;