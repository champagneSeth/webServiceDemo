using System.Collections.Generic;
using System.Web.Http;
using WebAPI2.Models;

namespace WebAPI2.Controllers
{
    public class ValuesController : ApiController
    {

        private static User seth = new User
        {
            Id = 1,
            FirstName = "Seth",
            LastName = "Champagne",
            UserName = "champagneSeth",
            Password = "prassword"
        };

        private static User tyler = new User();

        private static IEnumerable<User> users = new List<User> { seth, tyler };


        // GET api/values
        public IEnumerable<User> Get()
        {
            return users;
        }

        // GET api/values/5
        public User Get(int id)
        {
            if (id == 1) return seth;
            return new User();
        }

        // POST api/values
        public void Post(IEnumerable<User> value)
        {
            users = value;
        }

        // PUT api/values/5
        public void Put(int id, User value)
        {
            if (id == 1) seth = value;
        }

        // DELETE api/values/5
        public void Delete(int id)
        {
            seth = new User();
        }
    }
}
