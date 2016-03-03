using System.Web.Http;
using WebAPI2.Models;

namespace WebAPI2.Controllers
{
    public class UsersController : ApiController
    {
        public User GetUser()
        {
            User onlyUser = new User
            {
                Id = 1,
                FirstName = "Seth",
                LastName = "Champagne",
                UserName = "champagneSeth",
                Password = "prassword"
            };
            return onlyUser;
        }
    }
}
