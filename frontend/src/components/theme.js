import { createTheme }  from '@material-ui/core/styles';

const theme = createTheme({
  palette: {
    type: 'dark',
  primary: {
      main: '#B71C1C',
  },
  secondary: {
      main: '#6E6E6E',
  },
  tertiary: {
   main: '#EAEAEA',
  },
  background:{
    main: '#424242',
  },
 }
});

export default theme
