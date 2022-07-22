import React, { useState } from 'react';
import { gql, useMutation } from '@apollo/client';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import Link from '@mui/material/Link';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemIcon from '@mui/material/ListItemIcon';
import ListItemText from '@mui/material/ListItemText';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import { styled, useTheme, createTheme, ThemeProvider } from '@mui/material/styles';
import theme from './theme';

const MainCanvas = () =>{
  return(
       <Box
       sx={{
         display: 'flex',
         alignItems: 'flex-start',
         justifyContent: 'flex-start',
         minWidth: '95vw',
         minHeight: '96vh',
         mt: 3,
         borderRadius: 3,
         backgroundColor: '#B7B8B9',
         spacing: 2,
       }}
       color="#fff"
       >
         <p>Home Component Goes Here</p>
         <p>what what what</p>
       </Box>
  );
}

export default MainCanvas;
