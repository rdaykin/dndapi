// src/App.js

/*import React, { Component } from 'react';
import Skills from './components/skills';

class App extends Component {

  state = {
        skills: [],
        character: [],
        contacts: []
  }

  render () {
    return (
      <Skills skills={this.state.skills} />
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
  }
}

export default App;*/

// src/CharacterView.js

import React, { Component } from 'react';
import Character from './components/character';

class CharacterView extends Component {

  state = {
        character: []
  }

  render () {
    /*fetch("http://localhost:8080/character/Fred")
    .then(res => res.json())
    .then((data) => {
      console.log(data)
      this.setState({ character: data })
    })
    .catch(console.log)*/
    return (
      <Character character={this.state.character} />
    );
  }

  componentDidMount() {
    fetch("http://localhost:8080/character/Fred")
    .then(res => res.json())
    .then((data) => {
      console.log(data)
      this.setState({ character: data })
    })
    .catch(console.log)
  }
}

export default CharacterView;
