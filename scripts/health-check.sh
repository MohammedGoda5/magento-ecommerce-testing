#!/bin/bash
# Health check script for Magento site

SITE_URL="https://magento.softwaretestingboard.com"
MAX_RETRIES=3
RETRY_DELAY=5

for i in $(seq 1 $MAX_RETRIES); do
    echo "Attempt $i/$MAX_RETRIES: Checking $SITE_URL..."
    
    if curl -sf --max-time 10 "$SITE_URL" > /dev/null; then
        echo "? Site is accessible"
        exit 0
    else
        echo "? Site not accessible, waiting ${RETRY_DELAY}s..."
        sleep $RETRY_DELAY
    fi
done

echo "? Site is not accessible after $MAX_RETRIES attempts"
exit 1
