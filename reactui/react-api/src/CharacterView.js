// src/CharacterView.js

import React, { Component } from 'react';
import Character from './components/character';
import CharacterForm from './components/characterform'

class CharacterView extends Component {

  state = {
        character: []
  }

  render () {
    fetch("http://localhost:8080/character/Fred")
    .then(res => res.json())
    .then((data) => {
      console.log(data)
      this.setState({ character: data })
    })
    .catch(console.log)
    return (
      <div>
      <Character character={this.state.character} />
      <CharacterSkills character={this.state.character}/>
      </div>
    );
  }
}

export default CharacterView;
