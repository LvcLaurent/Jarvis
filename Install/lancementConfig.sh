#!/bin/bash

# -------------------------------------------------
# PARTIE A EDITER :
# -------------------------------------------------


SCREEN_VOICE="jarvisVoice" # nom utilisé pour le screen
NAME_VOICE="jarvisVoice" # nom du serveur, uniquement pour l'affichage des messages
COMMAND_VOICE="/home/laurent/Jarvis/jarvis/jarvis.sh" # commande de lancement du serveur

SCREEN_POSITION="jarvisPosition"
NAME_POSITION="jarvisPosition"
COMMAND_POSITION="/home/laurent/Jarvis/appLsi/lancementApp.sh"

SCREEN_MINECRAFT="Minecraft"
NAME_MINECRAFT="minecraft SevTechAge"
COMMAND_MINECRAFT="/home/laurent/SevTechAge2020/ServerStart.sh"
CD_MINECRAFT="/home/laurent/SevTechAge2020/"



if ! screen -list | grep -q "SCREEN_POSITION"
  then
	echo "Starting server [$NAME_POSITION]"
	screen -dmS $SCREEN_POSITION $COMMAND_POSITION
  else
	echo "Server [$NAME_POSITION] is already running"
fi



if ! screen -list | grep -q "SCREEN_VOICE"
  then
	echo "Starting server [$NAME_VOICE]"
	screen -dmS $SCREEN_VOICE $COMMAND_VOICE
  else
	echo "Server [$NAME_VOICE] is already running"
fi

sleep 2

screen -r $SCREEN_VOICE
echo "attente de 30s"

sleep 30

cd $CD_MINECRAFT
if ! screen -list | grep -q "SCREEN_MINECRAFT"
  then
	echo "Starting server [$NAME_MINECRAFT]"
	screen -dmS $SCREEN_MINECRAFT $COMMAND_MINECRAFT
  else
	echo "Server [$NAME_MINECRAFT] is already running"
fi






exit 0