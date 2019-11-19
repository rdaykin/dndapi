// src/components/skills.js

import React, {Component} from 'react'

class SavingThrows extends Component {



  state = {
    character: []
  }

  constructor(props){
    super(props)
    this.state.character = props.character
  }

  

  render (){
    var character = this.state.character
    return (<div>
          {character.strengthSave 
          || character.dexteritySave 
          || character.constitutionSave 
          || character.intelligenceSave 
          || character.wisdomSave
          || character.charismaSave? <strong>Saving Throws</strong>:null}
          {character.strengthSave? "Str " + (character.strengthSave > 0 ? "+":null) + character.strengthSave + ", ": null}
          {character.dexteritySave? "Dex " + (character.dexteritySave > 0 ? "+":null) + character.dexteritySave + ", ": null}
          {character.constitutionSave? "Con " + (character.constitutionSave > 0 ? "+":null) + character.constitutionSave + ", ": null}
          {character.intelligenceSave? "Int " + (character.intelligenceSave > 0 ? "+":null) + character.intelligenceSave + ", ": null}
          {character.wisdomSave? "Wis " + (character.wisdomSave > 0 ? "+":null) + character.wisdomSave + ", ": null}
          {character.charismaSave? "Cha " + (character.charismaSave > 0 ? "+":null) + character.charismaSave + ", ": null}
      </div>
    );
  }

}

export default SavingThrows
