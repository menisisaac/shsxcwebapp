const ResultList = (props) => {

    const results = props.results
    return (
        <div className='result-list'>
            <h2 style={{color:'red', textDecoration:'underline'}}>Results</h2>
            {results.map((result) => (
           <div className='result-info'>
            <a href={result.url}>{result.name}</a>
            
            </div>
        ))}
    </div>
    );
}
 
export default ResultList;