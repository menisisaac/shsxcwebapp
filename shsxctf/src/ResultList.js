const ResultList = (props) => {

    const results = props.results
    return (
        <div className='result-list'>
            <h1>Results</h1>
            {results.map((result) => (
           <div className='result-info'>
            <a href={result.url}>{result.name}</a>
            
            </div>
        ))}
    </div>
    );
}
 
export default ResultList;