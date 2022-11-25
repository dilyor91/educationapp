import React, { useEffect } from 'react';
import { Link, useParams } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { getEntity } from './addmission-rules.reducer';

export const AddmissionRulesDetail = () => {
  const dispatch = useAppDispatch();

  const { id } = useParams<'id'>();

  useEffect(() => {
    dispatch(getEntity(id));
  }, []);

  const addmissionRulesEntity = useAppSelector(state => state.addmissionRules.entity);
  return (
    <Row>
      <Col md="8">
        <h2 data-cy="addmissionRulesDetailsHeading">
          <Translate contentKey="educationApp.addmissionRules.detail.title">AddmissionRules</Translate>
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="id">
              <Translate contentKey="global.field.id">ID</Translate>
            </span>
          </dt>
          <dd>{addmissionRulesEntity.id}</dd>
          <dt>
            <span id="titleUz">
              <Translate contentKey="educationApp.addmissionRules.titleUz">Title Uz</Translate>
            </span>
          </dt>
          <dd>{addmissionRulesEntity.titleUz}</dd>
          <dt>
            <span id="titleRu">
              <Translate contentKey="educationApp.addmissionRules.titleRu">Title Ru</Translate>
            </span>
          </dt>
          <dd>{addmissionRulesEntity.titleRu}</dd>
          <dt>
            <span id="titleKr">
              <Translate contentKey="educationApp.addmissionRules.titleKr">Title Kr</Translate>
            </span>
          </dt>
          <dd>{addmissionRulesEntity.titleKr}</dd>
          <dt>
            <span id="contentUz">
              <Translate contentKey="educationApp.addmissionRules.contentUz">Content Uz</Translate>
            </span>
          </dt>
          <dd>{addmissionRulesEntity.contentUz}</dd>
          <dt>
            <span id="contentRu">
              <Translate contentKey="educationApp.addmissionRules.contentRu">Content Ru</Translate>
            </span>
          </dt>
          <dd>{addmissionRulesEntity.contentRu}</dd>
          <dt>
            <span id="contentKr">
              <Translate contentKey="educationApp.addmissionRules.contentKr">Content Kr</Translate>
            </span>
          </dt>
          <dd>{addmissionRulesEntity.contentKr}</dd>
          <dt>
            <span id="status">
              <Translate contentKey="educationApp.addmissionRules.status">Status</Translate>
            </span>
          </dt>
          <dd>{addmissionRulesEntity.status ? 'true' : 'false'}</dd>
        </dl>
        <Button tag={Link} to="/addmission-rules" replace color="info" data-cy="entityDetailsBackButton">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/addmission-rules/${addmissionRulesEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

export default AddmissionRulesDetail;
