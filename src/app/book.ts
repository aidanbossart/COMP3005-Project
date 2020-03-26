export class Book {
    constructor(private id: number, private name:string, private author:string, private genre:string, private pageNum: number, private price: number, private rating: number)
    {

    }

    public getId()
    {
        return this.id;
    }

    public getName()
    {
        return this.name;
    }

    public getAuthor()
    {
        return this.author;
    }

    public getGenre()
    {
        return this.genre;
    }

    public getPageNum()
    {
        return this.pageNum;
    }

    public getPrice()
    {
        return this.price;
    }

    public getRating()
    {
        return this.rating;
    }
}