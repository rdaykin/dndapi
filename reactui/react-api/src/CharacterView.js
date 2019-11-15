// src/CharacterView.js

import React, { Component } from 'react';
import Character from './components/character';

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
      <Character character={this.state.character} />
    );
  }
}

export default CharacterView;
