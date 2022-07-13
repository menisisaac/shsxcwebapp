const AnnoucementList = (props) => {
    const annoucement = props.annoucements;
    
    return (
        <div className='annoucement-list'>
        {annoucement.map((annoucement) => (
           <div className='annoucement-info' key={annoucement.id}>
            <h2>{annoucement.text}</h2>
            <p>Date: {annoucement.date}</p>
            </div>
        ))}
    </div>
    );
}
 
export default AnnoucementList;