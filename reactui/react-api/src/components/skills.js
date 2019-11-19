// src/components/skills.js

import React from 'react'

const Skills = ({ character }) => {
  return (
    <div>
        {character.acrobatics||
        character.animal_handling||
        character.arcana||
        character.athletics||
        character.deception||
        character.history||
        character.insight||
        character.intimidation||
        character.investigation||
        character.medicine||
        character.nature||
        character.perception||
        character.performance||
        character.persuasion||
        character.religion||
        character.sleight_of_hand||
        character.stealth||
        character.survival? <strong>Skills </strong> :null}
        {character.acrobatics? "Acrobatics " + (character.acrobatics>0? "+":null) + character.acrobatics + ", ":null}
        {character.animal_handling? "Animal Handling " + (character.animal_handling>0? "+":null) + character.animal_handling + ", ":null}
        {character.arcana? "Arcana " + (character.arcana>0? "+":null) + character.arcana + ", ":null}
        {character.athletics? "Athletics " + (character.athletics>0? "+":null) + character.athletics + ", ":null}
        {character.deception? "Deception " + (character.deception>0? "+":null) + character.deception + ", ":null}
        {character.history? "History " + (character.history>0? "+":null) + character.history + ", ":null}
        {character.insight? "Insight " + (character.insight>0? "+":null) + character.insight + ", ":null}
        {character.intimidation? "Intimidation " + (character.intimidation>0? "+":null) + character.intimidation + ", ":null}
        {character.investigation? "Investigation " + (character.investigation>0? "+":null) + character.investigation + ", ":null}
        {character.medicine? "Medicine " + (character.medicine>0? "+":null) + character.medicine + ", ":null}
        {character.nature? "Nature " + (character.nature>0? "+":null) + character.nature + ", ":null}
        {character.perception? "Perception " + (character.perception>0? "+":null) + character.perception + ", ":null}
        {character.performance? "Performance " + (character.performance>0? "+":null) + character.performance + ", ":null}
        {character.persuasion? "Persuasion " + (character.persuasion>0? "+":null) + character.persuasion + ", ":null}
        {character.religion? "Religion " + (character.religion>0? "+":null) + character.religion + ", ":null}
        {character.sleight_of_hand? "Sleight of Hand " + (character.sleight_of_hand>0? "+":null) + character.sleight_of_hand + ", ":null}
        {character.stealth? "Stealth " + (character.stealth>0? "+":null) + character.stealth + ", ":null}
        {character.survival? "Survival " + (character.survival>0? "+":null) + character.survival + ", ":null}<br/>
    </div>
    
  )
};

export default Skills
