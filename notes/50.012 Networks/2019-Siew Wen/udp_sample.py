from socket import *

# server
server_port = 12000
server_socket = socket(AF_INET, SOCK_DGRAM)
server_socket.bind("localhost",server_port)
print("The server ready to receive requests")
while True:
    message, client_address = server_socket.recvfrom(2048)
    modified_message = message.decode().upper()
    server_socket.sendto(modified_message.encode(), client_address)
    
# client

server_name = 'hostname'
server_port = 12000
client_socket = socket(AF_INET, SOCK_DGRAM)
message = "hi".encode()
client_socket.sendto(message,server_name, server_port)
modified_message, server_address =client_socket.recvfrom(2048)
print(modified_message.decode())
client_socket.close()
