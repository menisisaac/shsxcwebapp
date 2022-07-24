

const Grout = () => {
    return (
        <div className='grout'>
            <div className="containerThree">
            <div className="list-group grout-results-list">
                <li className="list-group-item">Results</li>
                <li className="list-group-item"><a href="https://section2harrier.com/crosscountry21/xc21groutinvy.html">2021</a></li>
                <li className="list-group-item"><a href="https://www.section2harrier.com/crosscountry19/xc19groutinvy.html">2019</a></li>
                <li className="list-group-item"><a href="https://section2harrier.com/crosscountry18/xc18groutinvy.html">2018</a></li>
                <li className="list-group-item"><a href="https://section2harrier.com/crosscountry17/xc17groutinvy.html">2017</a></li>
                <li className="list-group-item"><a href="https://section2harrier.com/crosscountry16/xc16groutinvy.html">2016</a></li>
                <li className="list-group-item"><a href="https://section2harrier.com/crosscountry15/xc15groutinvy.html">2015</a></li>
                <li className="list-group-item"><a href="https://section2harrier.com/crosscountry14/xc14groutinvy.htmlsche">2014</a></li>
            </div>
            <div className="list-group grout-information-list">
                <li className="list-group-item">Information</li>
                <li className="list-group-item"><a href="https://section2harrier.com/crosscountry21/xc21groutinvy.html">2022 Invitational Info</a></li>
                <li className="list-group-item"><a href="https://www.section2harrier.com/crosscountry19/xc19groutinvy.html">Course Map</a></li>
                <li className="list-group-item"><a href="https://section2harrier.com/crosscountry18/xc18groutinvy.html">Frosh/Mod Map</a></li>
                <li className="list-group-item"><a href="https://section2harrier.com/crosscountry17/xc17groutinvy.html">2022 Tee Shirt</a></li>
                <li className="list-group-item"><a href="https://dailygazette.com/2021/10/03/images-runners-compete-at-grout-invitational-in-schenectady-31-photos/">2021 Photos</a></li>
                <li className="list-group-item"><a href="https://www.timesunion.com/tuplus-sports/article/Grout-Invitational-offers-unique-challenge-9445716.php">Grout History</a></li>
                <li className="list-group-item"><a href="https://section2harrier.com/crosscountry14/xc14groutinvy.htmlsche">Volunteer Info</a></li>
            </div>
            <div className='gifHolder'>
                <img className='gif' src={require('./slideshow.GIF')}/>
            </div>
            </div>
            <div className="table-responsive">
                <table className="table table-hover table-dark">
                    <thead>
                        <tr>
                            <th scope="col">Course</th>
                            <th scope="col">Girls Varsity I</th>
                            <th scope="col">Boys Varsity I</th>
                            <th scope="col">Girls Varsity II</th>
                            <th scope="col">Boys Varsity II</th>
                            <th scope="col">Girls Varsity III</th>
                            <th scope="col">Boys Varsity III</th>
                            <th scope="col">Girls Class C</th>
                            <th scope="col">Boys Class C</th>
                            <th scope="col">JV Girls</th>
                            <th scope="col">JV Boys</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <th scope="row">New-2.75</th>
                            <td>Katelyn Touhy 14:37 2016</td>
                            <td>Alex Leuchenko 13:17.6 2008</td>
                            <td>Katelyn Touhy 14:06 2017</td>
                            <td>Martin Hehir 13:06 2010</td>
                            <td>Jen Fazioli 15:20 1995</td>
                            <td>Dan Acosta 13:19 1996</td>
                            <td>Julia Flower 15:48 2015</td>
                            <td>Dave Asmussen 13:53 1996</td>
                            <td>Valerie Beyers  16:47 1995</td>
                            <td>Joel Loke 14:25 2006</td>
                        </tr>
                        <tr>
                            <th scope="row">Old-2.86</th>
                            <td>Cheri Goddard 14:55 1988</td>
                            <td>Chris Nippert 13:11 1982</td>
                            <td>Chris Curtin 14:45 1982</td>
                            <td>Pete Lang 13:07 1984</td>
                            <td>Becky Pollock 15:47 1992</td>
                            <td>Marc Delfs 13:24 1989</td>
                            <td>Katie White 15:26 1991</td>
                            <td>O.J. Kastberg 13:25 1983</td>
                            <td>Erin Karl 16:19 1994</td>
                            <td>Dean  Fridorimo 14:24 1977</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    );
}
 
export default Grout;