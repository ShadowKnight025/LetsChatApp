import {React, useState} from 'react';
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import Link from '@mui/material/Link';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import LockOutlinedIcon from '@mui/icons-material/LockOutlined';
import EmailOutlinedIcon from '@mui/icons-material/EmailOutlined';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import { InputAdornment } from '@material-ui/core';
import {useNavigate} from 'react-router-dom'


function Copyright(props) {
    return (
      <Typography variant="body2" color="text.secondary" align="center" {...props}>
        {'All rights reserved to Lets Chat '}
        {' '}
        {new Date().getFullYear()}
        {'.'}
      </Typography>
    );
  }

const theme = createTheme();


const Reset = () => {
    const [data, setData] = useState({
        email: '', 
        error: null,
        loading: false,
    });

    const navigate = useNavigate(); 

    const {email, error, loading} = data;

    const handleChange = e => {
        setData({...data, [e.target.name]: e.target.value});
    };

    const handleSubmit = async e => {
        e.preventDefault();
        setData({...data, error: null, loading: true});
        if (!email){
            setData({...data, error: "Please fill out all input fields. "})
        }
        try {
          
            // code for connecting to db

                navigate('/login');
        } catch (err) {
            setData({...data, error: err.message, loading: false})
        } 
    };
    
        return (
            <ThemeProvider theme={theme}>
            <Container component="main" maxWidth="xs">
              <CssBaseline />
              <Box
                sx={{
                  marginTop: 8,
                  display: 'flex',
                  flexDirection: 'column',
                  alignItems: 'center',
                }}
              >
                <Avatar sx={{ m: 1, bgcolor: '#b71c1c' }}>
                  <LockOutlinedIcon />
                </Avatar>
                <Typography component="h1" variant="h5">
                  Password Reset
                </Typography>
      
                <Box component="form" noValidate onSubmit={handleSubmit} sx={{ mt: 3 }}>
                <Grid container spacing={2}>
                    <Grid item xs={12}>
                      <TextField
                        required
                        fullWidth
                        id="email"
                        label="Email"
                        name="email"
                        InputProps={{
                          endAdornment: (
                            <InputAdornment position="end">
                              <EmailOutlinedIcon />
                            </InputAdornment>
                          ),
                        }}
                      />
                    </Grid>
                  </Grid>
                  {error ? <p className='error'>{error}</p>: null}
                  <Button
                    type="submit"
                    fullWidth
                    variant="contained"
                    disabled={loading}
                    sx={{ mt: 2, mb: 2, bgcolor: '#b71c1c',
                    '&:hover': {
                      backgroundColor: '#E75A22',
                      color: 'black',
                      boxShadow: 3,
                  },
                  }}
                  >
                    {loading ? 'Sending Link...': 'Send Link'}
                  </Button>
                  <Grid container justifyContent="flex-end">
                    <Grid item>
                      <Link href="/login" variant="body2" align='right'>
                        Go back to login
                      </Link>
                    </Grid>
                  </Grid>
                  <Grid container justifyContent="flex-end">
                    <Grid item>
                      <Link href="/signup" variant="body2" align='right'>
                        Create new Account
                      </Link>
                    </Grid>
                  </Grid>
                </Box>
              </Box>
              <Copyright sx={{ mt: 5 }} />
            </Container>
          </ThemeProvider>
        );
      }
export default Reset;