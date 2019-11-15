// src/components/skills.js

import React from 'react'

const Skills = ({ skills }) => {
  return (
    <div>
      <center><h1>Skill List</h1>
      {skills.map((skill) => (
        <div>
          <h2 class="card-title">{skill.name}</h2>
          <p class="card-text">{skill.governingStat}</p>
        </div>
      ))}</center>
    </div>
  )
};

export default Skills
