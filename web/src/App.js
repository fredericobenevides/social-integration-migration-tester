import React from 'react';

import './App.css'

function App(props) {
  return (
    <div className="my_container">
      { props.children }
    </div>
  );
}

export default App;
