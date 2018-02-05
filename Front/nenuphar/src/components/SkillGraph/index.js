import React from 'react';
import {Doughnut} from 'react-chartjs';

const COLOR_GREEN = '#2ecc71';
const COLOR_RED = '#e74c3c';

export const GradeDoughnut = (props) => {
  const doughnutData = [{
    value: props.grade,
    color: COLOR_GREEN,
  },
  {
    value: props.maxGrade - props.grade,
    color: COLOR_RED,
  }
  ];
  return (
    <Doughnut data={doughnutData} />
  );
}

GradeDoughnut.defaultProps = { maxGrade: 5 };
