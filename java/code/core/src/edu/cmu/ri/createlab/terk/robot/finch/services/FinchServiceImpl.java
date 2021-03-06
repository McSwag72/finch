package edu.cmu.ri.createlab.terk.robot.finch.services;

import edu.cmu.ri.createlab.terk.TerkConstants;
import edu.cmu.ri.createlab.terk.properties.BasicPropertyManager;
import edu.cmu.ri.createlab.terk.properties.PropertyManager;
import edu.cmu.ri.createlab.terk.robot.finch.FinchController;
import edu.cmu.ri.createlab.terk.services.finch.BaseFinchServiceImpl;

/**
 * @author Chris Bartley (bartley@cmu.edu)
 */
final class FinchServiceImpl extends BaseFinchServiceImpl
   {
   static FinchServiceImpl create(final FinchController finchController)
      {
      final BasicPropertyManager basicPropertyManager = new BasicPropertyManager();

      basicPropertyManager.setReadOnlyProperty(TerkConstants.PropertyKeys.DEVICE_COUNT, finchController.getFinchProperties().getFinchDeviceCount());

      return new FinchServiceImpl(finchController,
                                  basicPropertyManager,
                                  finchController.getFinchProperties().getFinchDeviceCount());
      }

   private final FinchController finchController;

   private FinchServiceImpl(final FinchController finchController,
                            final PropertyManager propertyManager,
                            final int deviceCount)
      {
      super(propertyManager, deviceCount);
      this.finchController = finchController;
      }

   public void emergencyStop()
      {
      finchController.emergencyStop();
      }
   }