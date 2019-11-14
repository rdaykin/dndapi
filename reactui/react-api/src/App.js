// src/App.js

import React, { Component } from 'react';
import Skills from './components/skills';
import Contacts from './components/contacts'

class App extends Component {

  state = {
        skills: [],
        contacts: []
  }

  render () {
    return (
      <p><Skills skills={this.state.skills} />
      <Contacts contacts={this.state.contacts} /></p>
    );
  }

  componentDidMount() {
    fetch("http://localhost:8080/skills")
    .then(res => res.json())
    .then((data) => {
      console.log(data)
      this.setState({ skills: data })
    })
    .catch(console.log)
    fetch("http://jsonplaceholder.typicode.com/users")
    .then(res => res.json())
    .then((data) => {
      this.setState({ contacts: data })
    })
    .catch(console.log)
  }
}

export default App;
