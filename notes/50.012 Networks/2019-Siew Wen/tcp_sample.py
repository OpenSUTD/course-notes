from socket import *

# server
server_socket = socket(AF_INET, SOCK_STREAM)
server_socket.bind(("", 12000))
server_socket.listen(1)

# client
client_socket = socket(AF_INET, SOCK_STREAM)
client_socket.connect("localhost", 12000)

server_socket.close()