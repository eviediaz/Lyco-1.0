using System.Diagnostics;
using Microsoft.AspNetCore.SignalR;
using Microsoft.EntityFrameworkCore.Metadata.Internal;

namespace SignalRChat.Hubs
{
    public class ChatHub : Hub
    {
        public async Task SendMessage(string mode, string message, string editorID)
        {
            await Clients.All.SendAsync("ReceiveMessage", mode, message, editorID);
        }

        public async Task CreatePage(int tabID, string modeValue, string nomArchivo)
        {
            await Clients.All.SendAsync("ReceivePage", tabID, modeValue, nomArchivo);
        }


        public async Task DeletePage(string tabID)
        {
            await Clients.All.SendAsync("ErasePage", tabID);
        }
    }
}