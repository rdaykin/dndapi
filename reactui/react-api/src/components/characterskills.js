// src/components/skills.js

import React, {Component} from 'react'

class CharacterSkills extends Component {



  state = {
        character: []
  }

  constructor(props){
    super(props)
    this.state.character = props.character
    this.calculateBonus = this.calculateBonus.bind(this)
  }


  render (){
    var character = this.state.character
    console.log("CHARACTER 20: " + character.name)
    return (<div>
          {character.skills.map((skill) => {
            console.log(skill.name)
            return(
                <div>
                  <strong>{skill.name}:</strong>
                  {this.calculateBonus(character, skill)}
                </div>
            )
          }
          )
        }
      </div>
    );
}

  calculateBonus(character,skill) {
    var statValue = character[skill.governingStat.toString().toLowerCase()];
    console.log("Stat value: " + statValue)
    return (Math.floor(statValue/2) - 5);
  };

}

export default CharacterSkills
