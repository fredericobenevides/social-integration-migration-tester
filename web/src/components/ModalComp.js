import React from 'react';

import Modal from 'react-bootstrap/Modal';

const ModalComp = (props) => {
  let headerStyle = { backgroundColor: 'cyan'};
  if (props.data.title === 'ERRO') {
    headerStyle = { backgroundColor: 'red'};
  }

  return (
   <>
     <Modal centered show={props.data.show} onHide={props.onCloseModal} size="lg">
       <Modal.Header closeButton style={ headerStyle}>
         <Modal.Title>{props.data.title}</Modal.Title>
       </Modal.Header>

       <Modal.Body>
         <p>{props.data.msg}</p>
       </Modal.Body>
     </Modal>
   </>
  )
};

export default ModalComp;