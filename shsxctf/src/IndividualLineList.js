const IndividualLineList = (props) => {
    const result = props.results;
    
    return (
        <div className="result-page-list">
        {result.map((result) => (
           <div key={result.id}>
            <p>{result.desc}</p>
            </div>
        ))}
    </div>
    );
}
 
export default IndividualLineList;