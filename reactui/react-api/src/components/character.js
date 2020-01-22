// src/components/skills.js

import React, {Component}  from 'react'
import SavingThrows from './savingthrows'
import Skills from './skills'
import Actions from './action'

class Character extends Component {

  state = {
    character:[]
  }

  constructor(props){
    super(props)
    this.state.character = props.character
  }

  render(){
    var character = this.props.character
    return (
      <center>
        <div>
          <h1>{character.name}</h1>
          <div>
            <strong>Armour Class</strong> {character.armourClass}<br/>
            <strong>Hit Points</strong> {character.hitpoints} ( {character.hitDice})<br/>
            <strong>Speed</strong> {character.speed}<br/>
          </div>
          <div>
            <table className="table table-bordered table-condensed">
              <thead>
                <tr>
                  <th><strong>STR</strong></th>
                  <th><strong>DEX</strong></th>
                  <th><strong>CON</strong></th>
                  <th><strong>INT</strong></th>
                  <th><strong>WIS</strong></th>
                  <th><strong>CHA</strong></th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>{character.strength}</td>
                  <td>{character.dexterity}</td>
                  <td>{character.constitution}</td>
                  <td>{character.intelligence}</td>
                  <td>{character.wisdom}</td>
                  <td>{character.charisma}</td>
                </tr>
              </tbody>
            </table>
          </div>
          {character.name ? <SavingThrows character={character}/>: null}
          {character.name ? <Skills character={character}/>: null}
          {character.resistances && character.resistances != "" ? <strong>Damage Resistances </strong>:null} {character.resistances} {character.resistances !== "" ? <br/>:null}
          {character.immunities && character.immunities != "" ? <strong>Damage Immunities </strong>:null} {character.immunities} {character.immunities !== "" ? <br/>:null}
          {character.conditionImmunities && character.conditionImmunities != "" ? <strong>Condition Immunities </strong>:null} {character.conditionImmunities} {character.conditionImmunities !== "" ? <br/>:null}
          {character.senses && character.senses !== "" ? <strong>Senses </strong>:null} {character.senses} {character.senses !== "" ? <br/>:null}
          {character.languages && character.languages !== "" ? <strong>Languages </strong>:null} {character.languages} {character.languages !== "" ? <br/>:null}
          <strong>Challenge</strong> {character.challengeRating}
          {character.specialAbilities && character.specialAbilities !== [] ? <h2>Special Abilities</h2>: null}
          {character.specialAbilities && character.specialAbilities !== [] ? <Actions actions={character.specialAbilities}/>: null}
          {character.actions && character.actions !== [] ? <h2>Actions</h2>: null}
          {character.actions? <Actions actions={character.actions}/>: null}
        </div>
      </center>
    )
  }
};

export default Character
