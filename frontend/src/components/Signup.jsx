import React, { Component } from 'react';
import "bootstrap/dist/css/bootstrap.min.css";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faEnvelope, faUser, faLock } from '@fortawesome/free-solid-svg-icons'

class Signup extends Component {
    constructor(props) {
        super(props);
        
    }
    
    render() {
        return (
            <div>
                 <div className="container">
                    <div className="row">
                        <div className='card col-md-6 offset-md-3 offset-md-3'>
                            <h3 className="text-center">Sign Up</h3>
                            <div className="card-body">
                                <form>
                                    <div className="form-group" >
                                        <label>First Name</label>
                                        <div className='input-group-prepend'>
                                            <span className="input-group-text">
                                            <FontAwesomeIcon icon={faUser}/>
                                            </span>
                                            <input placeholder="Username" name='firstName' className='form-control' type="text" ></input>
                                        </div> 
                                    </div>
                                    <div className="form-group">
                                        <label>Last Name</label>
                                        <div className='input-group-prepend'>
                                            <span className="input-group-text">
                                            <FontAwesomeIcon icon={faUser}/>
                                            </span>
                                            <input placeholder='Last Name' name='lastName' className='form-control' type="text"  />
                                        </div> 
                                    </div>
                                    <div className="form-group">
                                        <label>Email</label>
                                        <div className='input-group-prepend'>
                                            <span className="input-group-text">
                                            <FontAwesomeIcon icon={faEnvelope}/>
                                            </span>
                                            <input placeholder='Email' name='email' className='form-control' type="email" />
                                        </div>
                                    </div>
                                    <div className="form-group">
                                        <label>Password</label>
                                        <div className='input-group-prepend'>
                                            <span className="input-group-text">
                                            <FontAwesomeIcon icon={faLock}/>
                                            </span>
                                            <input placeholder='Password' name='password' className='form-control' type="password" />
                                        </div>
                                    </div>
                                    <button className='btn btn-success'>Sign Up</button>
                                    <br />
                                    <a href="Login">Already have an account?</a>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default Signup;