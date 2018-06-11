package sample;

public class Map {
    private Tile tiles[][];


    Map()
    {
        tiles = new Tile[56][58];
        for( int i = 0; i < 56; i++)
        {
            for(int j = 0; j < 58; j++)
            {
                tiles[i][j].setCoordinates(j * 10, i * 10);
                if( i == 0 || i == 1 || i == 55 || i== 54 ) tiles[i][j].setWeb();
            }
        }
    }
}
