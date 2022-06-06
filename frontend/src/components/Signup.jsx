import React, { useState } from 'react';
import "bootstrap/dist/css/bootstrap.min.css";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faEnvelope, faUser, faLock } from '@fortawesome/free-solid-svg-icons'

const Signup = () => {
    const [data, setData] = useState({
        firstName: '',
        lastName: '',
        email: '',
        userName: '',
        password: '', 
        confirmPassword: '',
        error: null,
        loading: false,
    })
    const {firstName, lastName, email, userName, password, confirmPassword, error, loading} = data;

    const handleChange = e => {
        setData({...data, [e.target.name]: e.target.value});
    };

    const handleSubmit = async e => {
        e.preventDefault();
        setData({...data, error: null, loading: true});
        if (!firstName || !lastName || !userName || !email || !password || !confirmPassword){
            setData({...data, error: "Please fill out all input fields. "})
        }
        else if(password !== confirmPassword){
            setData({...data, error: "Passwords do not match"})
        }
        try {
            // function for registering user. 
        } catch (err) {
            // error function. 
        }
    }
        return (
            <div>
                 <div className="container">
                    <div className="row">
                        <div className='card col-md-6 offset-md-3 offset-md-3'>
                            <h3 className="text-center">Sign Up</h3>
                            <div className="card-body">
                                <form className='form' onSubmit={handleSubmit}>
                                    <div className="form-group" >
                                        <label>First Name</label>
                                        <div className='input-group-prepend'>
                                            <span className="input-group-text">
                                            <FontAwesomeIcon icon={faUser}/>
                                            </span>
                                            <input placeholder="First Name" name='firstName' className='form-control' type="text"
                                            value={firstName} onChange={handleChange} ></input>
                                        </div> 
                                    </div>
                                    <div className="form-group">
                                        <label>Last Name</label>
                                        <div className='input-group-prepend'>
                                            <span className="input-group-text">
                                            <FontAwesomeIcon icon={faUser}/>
                                            </span>
                                            <input placeholder='Last Name' name='lastName' className='form-control' type="text"
                                            value={lastName} onChange={handleChange} />
                                        </div> 
                                    </div>
                                    <div className="form-group">
                                        <label>Email</label>
                                        <div className='input-group-prepend'>
                                            <span className="input-group-text">
                                            <FontAwesomeIcon icon={faEnvelope}/>
                                            </span>
                                            <input placeholder='Email' name='email' className='form-control' type="email"
                                            value={email} onChange={handleChange} />
                                        </div>
                                    </div>
                                    <div className="form-group">
                                        <label>Username</label>
                                        <div className='input-group-prepend'>
                                            <span className="input-group-text">
                                            <FontAwesomeIcon icon={faUser}/>
                                            </span>
                                            <input placeholder='Email' name='email' className='form-control' type="email"
                                            value={email} onChange={handleChange} />
                                        </div>
                                    </div>
                                    <div className="form-group">
                                        <label>Password</label>
                                        <div className='input-group-prepend'>
                                            <span className="input-group-text">
                                            <FontAwesomeIcon icon={faLock}/>
                                            </span>
                                            <input placeholder='Password' name='password' className='form-control' type="password" 
                                            value={password} onChange={handleChange}/>
                                        </div>
                                    </div>
                                    <div className="form-group">
                                        <label>Confirm Password</label>
                                        <div className='input-group-prepend'>
                                            <span className="input-group-text">
                                            <FontAwesomeIcon icon={faLock}/>
                                            </span>
                                            <input placeholder='Password' name='confirmPassword' className='form-control' type="password"
                                            value={confirmPassword} onChange={handleChange} />
                                        </div>
                                    </div>
                                    {error ? <p className='error'>{error}</p>: null}
                                    <button className='btn btn-success'>
                                        {loading ? 'Creating User...': 'Sign Up'}
                                    </button>
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


export default Signup;